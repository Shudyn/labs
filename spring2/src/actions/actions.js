import axios from "axios";

const url = `http://localhost:8080`;
const headers = { 'Content-Type': 'application/json' };

export const getData = async (endpoint) => {
    try {
        const response = await axios.get(`${url+endpoint}`,
            {
                headers
            }
        )
        return response.data;
    } catch (e) {
        console.log('getData', e);
    }
}

export const createData = async (endpoint,data) => {
    try {
        const response = await axios.post(`${url+endpoint}`,
            data,
            headers
        )
        return response;
    } catch (e) {
        console.log('createData', e);
    }
}

export const removeData = async (endpoint, id) => {
    try {
        const response = await axios.delete(`${url+endpoint+'/'+id}`,
            headers
        )
        return response;
    } catch (e) {
        console.log('removeData', e);
    }
}
export const updateData = async (endpoint, data, id) => {
    try {
        const response = await axios.put(`${url+endpoint+'/'+id}`,
            data,
            headers
        )
        return response;
    } catch (e) {
        console.log('updateData', e);
    }
}