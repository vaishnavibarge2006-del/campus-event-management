import { useState } from "react";
import Navbar from "../layouts/Navbar";
import API from "../api/Api";
import "./Register.css";

function Register() {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [showPopup, setShowPopup] = useState(false);

  const handleRegister = async (e) => {
    e.preventDefault();

    try {
      await API.post("/api/users", {
        name: name,
        email: email,
        password: password
      });

      setShowPopup(true);

      setName("");
      setEmail("");
      setPassword("");

      setTimeout(() => {
        setShowPopup(false);
      }, 2500);

    } catch (error) {
      console.error(error);
    }
  };

  return (
    <>
      <Navbar />

      <div className="register-page">

        <div className="register-card">

          <h1>Register</h1>

          <p>Create your Campus Event account</p>

          <form onSubmit={handleRegister}>

            <div className="form-group">
              <label>Full Name</label>

              <input
                type="text"
                placeholder="Enter your full name"
                value={name}
                onChange={(e) => setName(e.target.value)}
                required
              />
            </div>

            <div className="form-group">
              <label>Email</label>

              <input
                type="email"
                placeholder="Enter your email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                required
              />
            </div>

            <div className="form-group">
              <label>Password</label>

              <input
                type="password"
                placeholder="Enter your password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                required
              />
            </div>

            <button
              type="submit"
              className="register-submit-btn"
            >
              Register
            </button>

          </form>

        </div>

        {showPopup && (
          <div className="success-popup">
            Registration successful!
          </div>
        )}

      </div>
    </>
  );
}

export default Register;