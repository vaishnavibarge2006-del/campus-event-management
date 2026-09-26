
import { useEffect, useState } from "react";
import Navbar from "../layouts/Navbar";
import API from "../api/Api";
import "./Events.css";
function Events() {
  const [events, setEvents] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  useEffect(() => {
    API.get("/api/events")
      .then((response) => {
        setEvents(response.data);
      })
      .catch((err) => {
        console.error(err);
        setError("Unable to load events.");
      })
      .finally(() => {
        setLoading(false);
      });
  }, []);

  return (
    <>
      <Navbar />

      <div className="events-page">
        <h1>Campus Events</h1>
        <p>Explore all upcoming campus events.</p>

        {loading && <p>Loading events...</p>}

        {error && <p>{error}</p>}

        {!loading && !error && events.length === 0 && (
          <p>No events available.</p>
        )}

        {!loading && !error && events.length > 0 && (
  <div className="event-container">
    {events.map((event) => (
      <div className="event-card" key={event.id}>
        <h2>{event.title || event.name}</h2>

        <p>{event.description}</p>

        <p>
  <strong>Location:</strong> {event.location || "Campus"}
</p>

        <button className="register-btn">
          Register
        </button>
      </div>
    ))}
  </div>
)}
      </div>
    </>
  );
}

export default Events;