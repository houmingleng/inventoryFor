import axios from 'axios'

const request = axios.create({
    baseURL: "http://localhost:9090/",
    // headers: {
    //     "Content-type": "application/json"
    // }
})


request.interceptors.request.use(config=>{
    return config
} , err => {
    return Promise.reject(err)
});

request.interceptors.response.use(
    response=> {
        let ress = response.data;
        console.log("response  "+response.data)
        if (response.config.responseType === 'blob') {
            return ress;
        }


        if (typeof ress === 'string') {
            ress = ress ? JSON.parse(ress) : ress
        }
        return ress;
    },
    err => {
        console.log('err'+ err)
        return Promise.reject(err)
    }

)
export default request
