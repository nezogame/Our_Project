import Login from "../../pages/login/Login";
import Main from "../../pages/main/Main";
import Profile from "../../pages/profile/Profile";
import Register from "../../pages/register/Register";

export type IRoute = {
  path: string;
  element: JSX.Element;
};

export const routes: IRoute[] = [
  {
    path: "/",
    element: <Main />,
  },
  {
    path: "/login",
    element: <Login />,
  },
  {
    path: "/register",
    element: <Register />,
  },
  {
    path: "/profile",
    element: <Profile />,
  },
];
