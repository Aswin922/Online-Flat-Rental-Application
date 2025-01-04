import { render } from "@testing-library/react";
import UpdateBooking from "./UpdateBooking";
import ReactDOM from 'react-dom';
import { BrowserRouter as Router} from "react-router-dom"

describe("RemoveBooking  Component",()=>{
    it("Render Update  table", () => {
        const { getByTestId } = render(<UpdateBooking />);
        const form = getByTestId("Update-form-2");
        expect(form).toBeTruthy();
      });

    it ("Rendered update ButtonBooking",()=>{
        const {getByTestId}=render(<Router><UpdateBooking/></Router>);
        const button =getByTestId("buttonBookingUpdate");
        expect(button).toBeTruthy();
    })

      it("Renders update header",()=>{
        const { getByTestId } = render(<UpdateBooking />);
        const header = getByTestId("update-header-2");
        expect(header).toBeTruthy();
    })
})