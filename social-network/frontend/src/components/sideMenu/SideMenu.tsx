import Bell from "../../assets/svg/Bell";
import "./SideMenu.scss";
import Send from "../../assets/svg/Send";

const SideMenu = () => {
  return (
    <div className="side-menu">
      <div className="top-bar">
        <div className="notifications">
          <div className="notification-identificator"></div>
          <Bell />
        </div>
        <div className="direct">
          <div className="notification-identificator"></div>
          <Send />
        </div>
        <div className="more">
          <div className="more-line"></div>
        </div>
      </div>
      <div className="suggested-accounts">
        <span className="title">Suggested Accounts</span>
        <div className="accounts">
          <div className="account">
            <img
              src="https://upload.wikimedia.org/wikipedia/commons/thumb/4/4d/Gull_ca_usa.jpg/220px-Gull_ca_usa.jpg"
              alt=""
            />
            Olivia Brooks
          </div>
          <div className="account">
            <img
              src="https://upload.wikimedia.org/wikipedia/commons/thumb/4/4d/Gull_ca_usa.jpg/220px-Gull_ca_usa.jpg"
              alt=""
            />
            Olivia Brooks
          </div>
          <div className="account">
            <img
              src="https://upload.wikimedia.org/wikipedia/commons/thumb/4/4d/Gull_ca_usa.jpg/220px-Gull_ca_usa.jpg"
              alt=""
            />
            Olivia Brooks
          </div>
          <div className="account">
            <img
              src="https://upload.wikimedia.org/wikipedia/commons/thumb/4/4d/Gull_ca_usa.jpg/220px-Gull_ca_usa.jpg"
              alt=""
            />
            Olivia Brooks
          </div>
        </div>
      </div>
      <div className="suggested-topics">
        <span className="title">Topics, you might be interested in</span>
        <div className="topics">
          <div className="topic"></div>
          <div className="topic"></div>
          <div className="topic"></div>
          <div className="topic"></div>
        </div>
      </div>
    </div>
  );
};

export default SideMenu;
