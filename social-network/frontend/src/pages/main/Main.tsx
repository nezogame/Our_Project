import { useEffect, useRef, useState } from "react";
import SearchBar from "../../components/searchBar/SearchBar";
import "./Main.scss";
import Starback from "starback";
import NewPost from "../../components/newPost/NewPost";
import Post from "../../components/post/Post";

const Main = () => {
  const canvasRef = useRef<HTMLCanvasElement>(null);
  const [starback, setStarback] = useState<Starback>();

  useEffect(() => {
    if (canvasRef.current) {
      setStarback(
        new Starback(canvasRef.current, {
          type: "dot",
          quantity: 100,
          direction: 180,
          backgroundColor: ["#0e1118", "#232b3e"],
          randomOpacity: true,
          starColor: "#ee7049",
        })
      );
    }
  }, []);
  return (
    <div className="main">
      <canvas className="canvas" id="canvas" ref={canvasRef}></canvas>
      <div className="main-content">
        <SearchBar />
        <NewPost />
        <div className="overflow-wrapper">
          <Post />
        </div>
      </div>
    </div>
  );
};

export default Main;
