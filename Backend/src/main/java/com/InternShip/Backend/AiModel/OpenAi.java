package com.InternShip.Backend.AiModel;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.converter.BeanOutputConverter;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi.ChatModel;
import org.springframework.ai.openai.api.OpenAiApi.ChatCompletionRequest.ResponseFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.InternShip.Backend.Exceptions.AiExceptions;
import com.InternShip.Backend.Model.Recepies.AiRecepie;
import com.InternShip.Backend.Model.Recepies.Nutrition;
import com.InternShip.Backend.Model.Users.UserResponse;

@RestController
@RequestMapping("/ai/")
public class OpenAi {

  @Autowired
  private OpenAiChatModel model;

  @GetMapping("/hello")
  public String sayhello(@RequestParam(name = "name", defaultValue = "Hello how are you") String name) {
    return model.call(name);
  }

  static String recepie;

  @GetMapping("/help/query")
  public UserResponse reponseOnUserQuery(@RequestParam(name = "Query") String Query) {

    StringBuffer sb = new StringBuffer(
        "You are a chatbot for a Recipe Hub management system  and answer to query of the users ");
    sb.append(Query);

    String resQuery = sb.toString();

    var outPutConverter = new BeanOutputConverter<>(UserResponse.class);

    var jsonSchema = outPutConverter.getJsonSchema();

    Prompt pt = new Prompt(resQuery, OpenAiChatOptions.builder()
        .withModel(ChatModel.GPT_4_O_MINI)
        .withResponseFormat(new ResponseFormat(ResponseFormat.Type.JSON_SCHEMA, jsonSchema))
        .build());

    ChatResponse response = this.model.call(pt);

    String Result = response.getResult().getOutput().getContent();

    if (Result.isEmpty()) {
      throw new AiExceptions("Sorry there was an error on our side");
    }

    return outPutConverter.convert(Result);
  }

  @GetMapping("/getInfo/Recepie")
  public AiRecepie getaRecepie(@RequestParam(name = "recepie") String recepie) {
    Prompt pt = new Prompt(recepie,
        OpenAiChatOptions.builder().withResponseFormat(
            new ResponseFormat(ResponseFormat.Type.JSON_SCHEMA,
                new BeanOutputConverter<>(AiRecepie.class).getJsonSchema()))
            .build());
    ChatResponse response = this.model.call(pt);
    String result = response.getResult().getOutput().getContent();
    return new BeanOutputConverter<>(AiRecepie.class)
        .convert(result);
  }

  @GetMapping("/getNutrition/info")
  public String nutritionInfo(
      @RequestParam(defaultValue = "Give random nutrition facts", name = "nutrition") String nutrition) {
    Prompt pt = new Prompt(nutrition,
        OpenAiChatOptions.builder().withResponseFormat(
            new ResponseFormat(ResponseFormat.Type.JSON_SCHEMA,
                new BeanOutputConverter<>(Nutrition.class).getJsonSchema()))
            .build());
    ChatResponse response = this.model.call(pt);
    String result = response.getResult().getOutput().getContent();
    return new BeanOutputConverter<>(Nutrition.class)
        .convert(result).toString();
  }
}
