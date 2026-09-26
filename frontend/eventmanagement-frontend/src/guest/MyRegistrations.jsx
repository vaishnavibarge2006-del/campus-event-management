import { useEffect, useState } from "react";
import Navbar from "../layouts/Navbar";
import API from "../api/Api";
import "./MyRegistrations.css";

function MyRegistrations() {

  const [registrations, setRegistrations] = useState([]);

  useEffect(() => {
    fetchRegistrations();
  }, []);

  const fetchRegistrations = async () => {
    try {
      const response = await API.get("/api/registrations");
      setRegistrations(response.data);
    } catch (error) {
      console.error("Failed to fetch registrations:", error);
    }
  };

  return (
    <>
      <Navbar />

      <div className="registrations-page">

        <h1>My Registrations</h1>

        {registrations.length === 0 ? (
          <p>No registrations found.</p>
        ) : (
          <div className="registrations-container">

            {registrations.map((registration) => (
              <div
                className="registration-card"
                key={registration.registrationId}
              >

                <h3>Campus Event</h3>

                <p>
                  <strong>Event ID:</strong>{" "}
                  {registration.eventId}
                </p>

                <p>
                  <strong>Registration Date:</strong>{" "}
                  {registration.registrationDate}
                </p>

                <p>
                  <strong>Status:</strong>{" "}
                  {registration.status}
                </p>

              </div>
            ))}

          </div>
        )}

      </div>
    </>
  );
}

export default MyRegistrations;