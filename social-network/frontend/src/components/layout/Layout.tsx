import Routing from "../routing/Routing";
import { useLocation } from "react-router-dom";
import Menu from "../menu/Menu";
import SideMenu from "../sideMenu/SideMenu";

const Layout: React.FC = () => {
  const location = useLocation();
  const isMenuSeen = !(location.pathname === "/login" || location.pathname === "/register");

  return (
    <>
      {isMenuSeen ? <Menu /> : false}
      <Routing />
      {isMenuSeen ? <SideMenu /> : false}
    </>
  );
};

export default Layout;
