import Glass from "../../assets/svg/Glass";
import Micro from "../../assets/svg/Micro";
import "./SearchBar.scss";

const SearchBar = () => {
  return (
    <div className="search-bar">
      <Glass />
      <input type="text" />
      <Micro />
    </div>
  );
};

export default SearchBar;
