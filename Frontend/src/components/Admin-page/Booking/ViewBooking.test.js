import { render } from "@testing-library/react";
import ViewBooking from "./ViewBooking";
import ReactDOM from 'react-dom';
import { BrowserRouter as Router} from "react-router-dom"

describe("RemoveBooking  Component",()=>{
    it("Rendered View table", () => {
        const { getByTestId } = render(<ViewBooking />);
        const form = getByTestId("View-form-2");
        expect(form).toBeTruthy();
      });

    it ("Rendered update ButtonBooking",()=>{
        const {getByTestId}=render(<Router><ViewBooking/></Router>);
        const button =getByTestId("buttonBookingViewId");
        expect(button).toBeTruthy();
    })
})