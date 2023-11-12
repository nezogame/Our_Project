import { PayloadAction, createSlice } from "@reduxjs/toolkit";
import { RootState } from "../../app/store";

export interface LanguageState {
  language: string;
}

const initialState: LanguageState = {
  language: "English",
};

export const languageSlice = createSlice({
  name: "language",
  initialState,
  // The `reducers` field lets us define reducers and generate associated actions
  reducers: {
    changeLanguage: (state, action: PayloadAction<LanguageState>) => {
      state.language = action.payload.language;
    },
  },
});

export const { changeLanguage } = languageSlice.actions;

export const selectLanguage = (state: RootState) => state.language.language;

export default languageSlice.reducer;
