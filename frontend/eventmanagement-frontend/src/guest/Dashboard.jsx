import { useState } from "react";
import Navbar from "../layouts/Navbar";
import API from "../api/Api";
import "./Dashboard.css";

function Dashboard() {

  const [showPopup, setShowPopup] = useState(false);

  const handleRegister = async () => {

    try {

      await API.post("/api/registrations", {
        userId: 1,
        eventId: 1,
        registrationDate: new Date().toISOString().split("T")[0],
        status: "Registered"
      });

      setShowPopup(true);

      setTimeout(() => {
        setShowPopup(false);
      }, 2500);

    } catch (error) {

      console.error("Registration failed:", error);

    }
  };

  return (
    <>
      <Navbar />

      <div className="dashboard-page">

        <div className="dashboard-header">
          <h1>Welcome, User</h1>
          <p>Manage your campus events</p>
        </div>

        <div className="dashboard-section">

          <h2>Available Events</h2>

          <div className="event-card">

            <h3>Campus Event</h3>

            <p>
              Join exciting events organized on campus.
            </p>

            <button
              className="register-event-btn"
              onClick={handleRegister}
            >
              Register
            </button>

          </div>

        </div>
        <a
        href="/my-registrations"
        className="my-registrations-btn"
        >
        My Registrations
        </a>
        <button
        className="logout-btn"
         onClick={() => window.location.href = "/"}
        >
         Logout
        </button>

        {showPopup && (
          <div className="success-popup">
            Event registration successful!
          </div>
        )}

      </div>
    </>
  );
}

export default Dashboard;