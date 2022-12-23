import { useState } from "react";
import { useEffect } from "react";
import { getData } from "../actions/actions";
import Table from "../components/table/table";

export default function TableGenerator({endpoint, headArray, bodyArray}) {
    const [data, setData] = useState()

    useEffect(() => {//для вызова запроса на сервер
        getData(endpoint).then((e) => setData(e)) //вызов функции запроса на сервер
    }, [])

    

    return (
        <Table
            head={headArray} //название колонок в таблице
            body={bodyArray}//название ключа объекта для отрисовки
            data={data}//массив объектов
        />
    )
}