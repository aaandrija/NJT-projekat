import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Navbar from "./components/Navbar";
 import Home from "./pages/home";
import Login from "./pages/login";
 import Register from "./pages/register";

import Proizvodi from "./pages/knjige";
import Recenzije  from "./pages/recenzije";
import VerifikacijaEmail from "./pages/dovrsi_verifikaciju";
 import Korpa from "./pages/korpa";
import Porudzbine from "./pages/porudzbine";
import Admin from "./pages/admin";

function App() {
  return (
    <BrowserRouter>
      <Navbar />
      <Routes>
         <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route path="/knjige" element={<Proizvodi />} />
        <Route path="/recenzije" element={<Recenzije />} />
         <Route path="/korpa" element={<Korpa />} />
         <Route path="/verifikuj" element={<VerifikacijaEmail />} />
          <Route path="/admin" element={<Admin />} />
          <Route path="/porudzbine" element={<Porudzbine />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
