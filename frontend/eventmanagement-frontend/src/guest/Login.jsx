import { useState } from "react";
import { useNavigate } from "react-router-dom";
import Navbar from "../layouts/Navbar";
import API from "../api/Api";
import "./Login.css";

function Login() {
  const navigate = useNavigate();
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [showPopup, setShowPopup] = useState(false);
  const [error, setError] = useState("");

  const handleLogin = async (e) => {
    e.preventDefault();

    try {

      const response = await API.post("/api/users/login", {
        email: email,
        password: password
      });

      console.log("Login successful:", response.data);

      setShowPopup(true);
      setError("");

      setEmail("");
      setPassword("");

      setTimeout(() => {
  navigate("/dashboard");
}, 1500);
      setTimeout(() => {
        setShowPopup(false);
      }, 2500);

    } catch (error) {

      console.error(error);

      setError("Invalid email or password.");
      setShowPopup(false);
    }
  };

  return (
    <>
      <Navbar />

      <div className="login-page">

        <div className="login-card">

          <h1>Login</h1>

          <p>Login to your Campus Event account</p>

          <form onSubmit={handleLogin}>

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
              className="login-btn"
            >
              Login
            </button>

          </form>

          {error && (
            <p className="login-error">
              {error}
            </p>
          )}

        </div>

        {showPopup && (
          <div className="success-popup">
            Login successful!
          </div>
        )}

      </div>
    </>
  );
}

export default Login;