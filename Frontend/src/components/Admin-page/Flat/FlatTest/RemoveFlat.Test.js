import { render } from "@testing-library/react";
import RemoveFlat from "./../RemoveFlat";
import ReactDOM from 'react-dom';
import { BrowserRouter as Router} from "react-router-dom"

describe("Remove Flat Component",()=>{
    it("Renders without crashing",()=>{
        const div =document.createElement('div');
         ReactDOM.render(<Router><RemoveFlat/></Router>,div);
    })
    it ("Rendered Remove Button",()=>{
        const {getByTestId}=render(<Router><RemoveFlat/></Router>);
        const button =getByTestId("button");
        expect(button).toBeTruthy();
    })
})