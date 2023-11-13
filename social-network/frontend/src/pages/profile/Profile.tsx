import Calendar from "../../assets/svg/Calendar";
import Earth from "../../assets/svg/Earth";
import "./Profile.scss";

const Profile = () => {
  return (
    <div className="profile">
      <div className="user-profile-photo">
        <img
          src="https://images.wallpaperscraft.ru/image/single/chajka_ptitsa_krik_107126_300x168.jpg"
          alt=""
          className=""
        />
      </div>
      <div className="profile-wrapper">
        <div className="background"></div>
        <div className="profile-info">
          <div className="profile-left">
            <div className="top">
              <div className="name">Ilon Dusk</div>
              <div className="location">
                <Earth />
                Alabama, USA
              </div>
            </div>
            <div className="bottom">
              <div className="joined">
                <Calendar /> Joined September 2007
              </div>
            </div>
          </div>
          <div className="profile-right">
            <div className="photos">
              <div className="count"></div>
              Photos
            </div>
            <div className="followers">
              <div className="count"></div>
              Followers
            </div>
          </div>
        </div>
        <div className="create-post">
          <input type="text" className="" />
        </div>
        <div className="post">
          <div className="user-wrapper">
            <div className="user-img">
              <img src="" alt="" className="" />
            </div>
            <div className="user-info">
              <div className="user-name"></div>
              <div className="post-creation-date"></div>
            </div>
          </div>
        </div>
      </div>
      <div className="side-panel"></div>
    </div>
  );
};

export default Profile;
