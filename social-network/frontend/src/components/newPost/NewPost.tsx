import Folder from "../../assets/svg/Folder";
import IMGBox from "../../assets/svg/IMGBox";
import "./NewPost.scss";

const NewPost = () => {
  return (
    <div className="newPost">
      <span className="title">New Post...</span>
      <IMGBox />
      <Folder />
    </div>
  );
};

export default NewPost;
