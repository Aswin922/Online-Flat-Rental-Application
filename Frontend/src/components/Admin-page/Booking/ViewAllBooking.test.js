import { render } from "@testing-library/react";
import ViewAllBooking from "./ViewAllBooking";
import ReactDOM from 'react-dom';
import { BrowserRouter as Router} from "react-router-dom"

describe("RemoveBooking  Component",()=>{
    it("Rendered ViewAll table", () => {
        const { getByTestId } = render(<ViewAllBooking />);
        const form = getByTestId("ViewAll-form-2");
        expect(form).toBeTruthy();
      });
})