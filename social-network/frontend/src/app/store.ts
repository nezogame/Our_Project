import { configureStore, ThunkAction, Action } from "@reduxjs/toolkit";
import counterReducer from "../features/counter/counterSlice";
import loginReducer from "../features/login/loginSlice";
import themeReducer from "../features/theme/themeSlice";
import languageReducer from "../features/language/languageSlice";

export const store = configureStore({
  reducer: {
    counter: counterReducer,
    login: loginReducer,
    theme: themeReducer,
    language: languageReducer,
  },
});

export type AppDispatch = typeof store.dispatch;
export type RootState = ReturnType<typeof store.getState>;
export type AppThunk<ReturnType = void> = ThunkAction<ReturnType, RootState, unknown, Action<string>>;
