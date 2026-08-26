import { BrowserRouter, Routes, Route } from "react-router-dom";

// ------------ all path of page -----------
import Login from "./components/login/Login.jsx"
import Register from "./components/register/Registerpage.jsx"
import Dashboard from "./components/Dashboard/dashboard.jsx"


export default function App(){

  return (

    <BrowserRouter>
    <Routes>

      <Route path="/" element={<Login/>} />
      <Route path="/register" element={<Register/>} />
      <Route path="/dashboard" element={<Dashboard/>}/>





    </Routes>
    
    </BrowserRouter>
    
    
   



  );
}