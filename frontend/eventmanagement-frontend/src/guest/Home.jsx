import Navbar from "../layouts/Navbar";
import "./Home.css";

function Home() {
  return (
    <>
      <Navbar />

      <section className="hero">
        <div className="hero-content">
          <h1>Campus Event Management</h1>

          <div className="hero-buttons">
            <a href="/events" className="btn primary-btn">
              Explore Events
            </a>

            <a href="/register" className="btn secondary-btn">
              Register Now
            </a>
          </div>
        </div>
      </section>

      <section className="features">
        <h2>What You Can Do</h2>

        <div className="feature-container">

  <a href="/events" className="feature-card">
    <h3>🎓 Explore Events</h3>
    <p>View upcoming events organized on campus.</p>
  </a>

  <a href="/register" className="feature-card">
    <h3>📝 Register Easily</h3>
    <p>Register for your favorite campus events.</p>
  </a>

  <a href="/my-registrations" className="feature-card">
    <h3>📅 Manage Registrations</h3>
    <p>Keep track of your registered events.</p>
  </a>

</div>
      </section>
    </>
  );
}

export default Home;