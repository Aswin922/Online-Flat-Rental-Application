import { render } from "@testing-library/react";
import RemoveBooking from "./RemoveBooking";
import ReactDOM from 'react-dom';
import { BrowserRouter as Router} from "react-router-dom"

describe("RemoveBooking  Component",()=>{
  
    it ("Rendered Add ButtonBooking",()=>{
        const {getByTestId}=render(<Router><RemoveBooking/></Router>);
        const button =getByTestId("buttonBookingRemove");
        expect(button).toBeTruthy();
    })

    // it("Renders add header",()=>{
    //     const { getByTestId } = render(<RemoveBooking />);
    //     const header = getByTestId("Remove-header-2");
    //     expect(header).toBeTruthy();
    // })
})