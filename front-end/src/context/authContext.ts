import { createContext } from "react";

export type User = {
    "name" : string,
    "login" : string,
    basicAuth : string,
    "id_client" : number,
    "role" : {
        "authority" : string
    } []

}

export type AuthType = {
    user? : User
    updateUser?(user?: User | undefined) : void
}

const initialValue: AuthType = {}

export const AuthContext = createContext(initialValue);
