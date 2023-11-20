import "./Post.scss";

const Post = () => {
  return (
    <div className="post">
      <div className="post-header">
        <div className="user">
          <img
            src="data:image/jpeg;base64,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"
            alt=""
          />
          <div className="user-info">
            <div className="name">Emilia Sanchez</div>
            <div className="date-of-publication">November 18, 2023</div>
          </div>
        </div>
        <div className="dots">
          <div className="dot"></div>
        </div>
      </div>
      <div className="post-main">
        <div className="text">The best November in my life! #picnic #autumn #fun </div>
        <div className="photos">
          <div className="photo-wrapper">
            <img src="https://i.pinimg.com/originals/8a/e4/6f/8ae46f8ae5552d09ad8289b46f65cc55.jpg" alt="" />
            <img src="https://i.pinimg.com/originals/a7/ce/1b/a7ce1b5fbae7b5c3b22a250872efe3aa.jpg" alt="" />
          </div>

          <img
            src="https://e0.pxfuel.com/wallpapers/162/811/desktop-wallpaper-summer-sunflowers-nature-graphy-landscape-graphy-nature-aesthetic-graphy-nature-aesthetic-sunny-thumbnail.jpg"
            alt=""
          />
        </div>
        <div className="post-stats">
          <div className="likes"> 1.2k likes</div>
          <div className="comments"> 324 comments</div>
          <div className="views"> 3.4k views</div>
        </div>
        <div className="functions">
          <div className="like">Like</div>
          <div className="comment">Comment</div>
          <div className="share">Share</div>
        </div>
      </div>
    </div>
  );
};

export default Post;
