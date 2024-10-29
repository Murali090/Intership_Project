import HomePage from "./Componenets/Home/HomePage";
import Login from "./Componenets/Login/Login";

import { BrowserRouter, Route, Routes } from "react-router-dom";
export default function App() {

  return (
    <>
      <div className="container">
        <BrowserRouter>
          <Routes>
            <Route path="/" element={<Login />} />
            <Route path="/home" element={<HomePage />} />
            {/* <Route path="/login" element={<LoginComponent />} /> */}
            {/* <Route path="/welcome/:username" element={<AuthenticatedRoute><WelcomePage /> </AuthenticatedRoute>} /> */}
            {/* <Route path="/todo" element={<AuthenticatedRoute><ListTodoComponent /> </AuthenticatedRoute>} /> */}
            {/* <Route path="/error" element={<Error />} /> */}
            {/* <Route path="/logout" element={<AuthenticatedRoute><Logout /></AuthenticatedRoute>} /> */}
          </Routes>
        </BrowserRouter >
      </div >
    </>
  )
}



