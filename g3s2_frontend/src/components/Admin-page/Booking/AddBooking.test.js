import { render } from "@testing-library/react";
import AddBooking from "./AddBooking";
import ReactDOM from 'react-dom';
import { BrowserRouter as Router} from "react-router-dom"

describe("AddBooking  Component",()=>{
    // it("Rendered Add table", () => {
    //     const { getByTestId } = render(<AddBooking />);
    //     const form = getByTestId("Add-form-2");
    //     expect(form).toBeTruthy();
    //   });

    it ("Rendered Add ButtonBooking",()=>{
        const {getByTestId}=render(<Router><AddBooking/></Router>);
        const button =getByTestId("buttonBooking");
        expect(button).toBeTruthy();
    })

    it("Renders add header",()=>{
        const { getByTestId } = render(<AddBooking />);
        const header = getByTestId("Add-header-2");
        expect(header).toBeTruthy();
    })
})