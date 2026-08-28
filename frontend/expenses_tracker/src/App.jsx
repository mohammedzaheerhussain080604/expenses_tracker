import { BrowserRouter, Routes, Route } from "react-router-dom";

// ------------ all path of page -----------
import Login from "./components/login/Login.jsx"
import Register from "./components/register/Registerpage.jsx"
import Dashboard from "./components/Dashboard/dashboard.jsx"
import Navbar from "./components/Navbar/Navbar.jsx"
import AddExpense from "./components/Add/add-es.jsx"
import Expenses from "./components/Expenses/expenses.jsx"



export default function App(){

  return (

    <BrowserRouter>
    <Routes>

      <Route path="/" element={<Login/>} />
      <Route path="/register" element={<Register/>} />
      <Route path="/dashboard" element={<Dashboard/>}/>
      <Route path="/navbar" element={<Navbar/>}/>
      <Route path="/add-expenses" element={<AddExpense/>} />
      <Route path="/expenses" element={<Expenses/>} />






    </Routes>
    
    </BrowserRouter>
    
    
   



  );
}