import { useRef, useState } from "react";
import Abstraction from "../../assets/png/Abstraction.png";
import Github from "../../assets/svg/Github";
import Google from "../../assets/svg/Google";
import "./Register.scss";
import { Link } from "react-router-dom";
import { useAppDispatch, useAppSelector } from "../../app/hooks";
import { changeTheme, selectTheme } from "../../features/theme/themeSlice";
import Sun from "../../assets/svg/Sun";
import Moon from "../../assets/svg/Moon";
import Eye from "../../assets/svg/Eye";
import { selectLanguage, changeLanguage } from "../../features/language/languageSlice";

const Register = () => {
  const emailRef = useRef<HTMLInputElement>(null);
  const usernameRef = useRef<HTMLInputElement>(null);
  const passwordRef = useRef<HTMLInputElement>(null);
  const passwordRepeatRef = useRef<HTMLInputElement>(null);
  const eyeRef = useRef<SVGSVGElement>(null);
  const [isPasswordShown, setIsPasswordShown] = useState<boolean>(false);
  const [login, setLogin] = useState<string>("");
  const [password, setPassword] = useState<string>("");
  const dispatch = useAppDispatch();
  const theme = useAppSelector(selectTheme);
  //const language = useAppSelector(selectLanguage);

  const getFormBack = () => {
    const token = "e1213t234t6235uy245ueqqwfqwfqqeg";
    const jsonResponse = JSON.stringify({ token: token });

    return new Response(jsonResponse, {
      status: 400, // HTTP status code
      headers: {
        "Content-Type": "application/json",
      },
    });
  };

  const logIn = async (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();

    const response = await getFormBack();
    const data = await response.json();
    console.log(response);
    if (!response.ok) {
      emailRef.current!.value = "";
      emailRef.current!.placeholder = "Wrong login or password";

      return;
    }
    localStorage.setItem("token", data.token);
  };

  const toggleTheme = () => {
    dispatch(changeTheme());
  };

  const changeLang = (e: React.ChangeEvent<HTMLSelectElement>) => {
    dispatch(changeLanguage({ language: e.target.value }));
  };

  const showPassword = (
    setIsPasswordShown: React.Dispatch<React.SetStateAction<boolean>>,
    ref: React.RefObject<HTMLInputElement>
  ) => {
    if (ref.current) {
      if (ref.current.type === "password") {
        ref.current.type = "text";
      } else {
        ref.current.type = "password";
      }
    }
    setIsPasswordShown((prev) => !prev);
  };

  return (
    <div className={`wrapper ${theme}`}>
      <div className="change-theme-btn" onClick={() => toggleTheme()}>
        {theme === "light" ? <Sun /> : <Moon />}
      </div>
      <div className="form register">
        <div className="left-side">
          <div className="logo">LOGO</div>
          <div className="text-img-wrapper">
            <span className="text">
              Lorem ipsum dolor sit, amet consectetur adipisicing elit. Eos, blanditiis praesentium voluptatibus quia
              nobis
            </span>
            <img src={Abstraction} alt="" className="abstraction" />
          </div>
        </div>
        <div className="right-side">
          <div className="select-wrapper">
            <select name="language" id="language" className="language" onChange={(e) => changeLang(e)}>
              <option value="English">English</option>
              <option value="Ukrainian">Ukrainian</option>
            </select>
          </div>
          <form className="register-form" onSubmit={logIn}>
            <div className="title">Sign up</div>
            <div className="alternative-login">
              <div className="google-btn">
                <Google /> Sign in with Google
              </div>
              <div className="github-btn">
                <Github /> Sign in with Github
              </div>
            </div>
            <div className="or">OR</div>
            <div className="input-wrapper">
              <div className="error-wrapper">
                <input
                  type="text"
                  className="email"
                  placeholder="Email Address"
                  onChange={(e) => setLogin(e.target.value)}
                  ref={emailRef}
                  required
                />
              </div>
              <div className="error-wrapper">
                <input
                  type="text"
                  className="username"
                  placeholder="Username"
                  onChange={(e) => setPassword(e.target.value)}
                  ref={usernameRef}
                  required
                />
              </div>
              <div className="error-wrapper">
                <div className="password-wrapper">
                  <input
                    type="password"
                    className="password"
                    placeholder="Password"
                    onChange={(e) => setPassword(e.target.value)}
                    ref={passwordRef}
                    required
                  />
                  <Eye showPassword={showPassword} passRef={passwordRef} />
                </div>
              </div>
              <div className="error-wrapper">
                <div className="password-wrapper">
                  <input
                    type="password"
                    className="password"
                    placeholder="Repeat password"
                    onChange={(e) => setPassword(e.target.value)}
                    ref={passwordRepeatRef}
                    required
                  />
                  <Eye showPassword={showPassword} passRef={passwordRepeatRef} />
                </div>
              </div>
            </div>
            <input type="submit" value="Sign up" className="submit" />
            <span className="sign-up">
              Do you have an account?{" "}
              <Link to="/login" className="sign-up-btn">
                Sign in
              </Link>
            </span>
          </form>
        </div>
      </div>
    </div>
  );
};

export default Register;
