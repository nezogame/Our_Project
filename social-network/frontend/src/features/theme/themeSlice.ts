import { createSlice } from "@reduxjs/toolkit";
import { RootState } from "../../app/store";

export interface ThemeState {
  theme: string;
}

const initialState: ThemeState = {
  theme: "light",
};

export const themeSlice = createSlice({
  name: "theme",
  initialState,
  // The `reducers` field lets us define reducers and generate associated actions
  reducers: {
    changeTheme: (state) => {
      if (state.theme === "light") {
        state.theme = "dark";
      } else {
        state.theme = "light";
      }
    },
  },
});

export const { changeTheme } = themeSlice.actions;

export const selectTheme = (state: RootState) => state.theme.theme;

export default themeSlice.reducer;
