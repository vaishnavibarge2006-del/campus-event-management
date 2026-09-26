import { BrowserRouter, Routes, Route } from "react-router-dom";
import Events from "./guest/Events";
import Home from "./guest/Home";
import Login from "./guest/Login";
import Register from "./guest/Register";
import Dashboard from "./guest/Dashboard";
import MyRegistrations from "./guest/MyRegistrations";

function App() {
  return (
    <BrowserRouter>
      <Routes>

        <Route path="/" element={<Home />} />

        <Route path="/login" element={<Login />} />

        <Route path="/register" element={<Register />} />
        
        <Route path="/events" element={<Events />} />

        <Route path="/dashboard" element={<Dashboard />} />

        <Route path="/my-registrations"element={<MyRegistrations />}/>
      </Routes>
    </BrowserRouter>
  );
}

export default App;