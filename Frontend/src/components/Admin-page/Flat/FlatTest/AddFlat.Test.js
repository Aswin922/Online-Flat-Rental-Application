import { render } from "@testing-library/react";
import AddFlat from "./../AddFlat";
import ReactDOM from 'react-dom';
import { BrowserRouter as Router} from "react-router-dom"

describe("Add Flat Component",()=>{
    it("Renders without crashing",()=>{
        const div =document.createElement('div');
         ReactDOM.render(<Router><AddFlat/></Router>,div);
    })
    it ("Rendered Add Button",()=>{
        const {getByTestId}=render(<Router><AddFlat/></Router>);
        const button =getByTestId("button");
        expect(button).toBeTruthy();
    })
})