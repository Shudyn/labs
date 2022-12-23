import { useMemo } from 'react';
import { useState } from 'react'
import { createData, updateData } from '../../../actions/actions';
import Input from '../../../components/input/input'
import '../form.css'

export default function UpdateOperationForm() {
    const [id, setId] = useState('');
    const [barcode, setbarcode] = useState('');
    const [countOfItem, setCount] = useState('');
    const [employeeId, setEmployee] = useState('');

    const memoDisabled = useMemo(() => {
        return (!id);
    }, [id, barcode, countOfItem, employeeId,])

    const handleSubmit = (e) => {
        e.preventDefault();
        updateData('/operation' ,{
            id: id,
            barcode: barcode,
            countOfItem: countOfItem,
            employeeId: employeeId,
        }, id)
    }

    return (
        <form className="container_form" onSubmit={handleSubmit}>
            <Input label='ID' change={(e) => setId(e.value)} />
            <Input label='Баркод' change={(e) => setbarcode(e.value)} />
            <Input label='Единицы' change={(e) => setCount(e.value)} />
            <Input label='ID Сотрудника' change={(e) => setEmployee(e.value)} />
            <button type="submit" className={memoDisabled ? 'disabled' : ''} disabled={memoDisabled} >Submit</button>
        </form>
    )
}