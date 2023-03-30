import axios from 'axios';
import { config } from '../Constant'

export const LoginAPI = {
    authenticate,
    getUser
}


const instance = axios.create({
    baseURL: config.url.BASE_URL
})

function authenticate (username:any, password:any){
    return instance.post('/auth/authenticate', {username, password} , {
        headers: {'Content-Type' : 'application/json'}
    })
}

function getUser (user:any, username:any ) {
    const url = username ? `/clients${username}` : 'clients'
    return instance.get(url, {
        headers: {'Authorization': basicAuth(user)}
    })
}

function basicAuth(user:any){
    return `Basic ${user.authdata}`
}
