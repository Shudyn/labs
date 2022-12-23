import { useMemo } from 'react';
import { useState } from 'react'
import { createData } from '../../../actions/actions';
import Input from '../../../components/input/input'
import '../form.css'

export default function CreateOperationForm() {
    const [type, setType] = useState('');
    const [barcode, setbarcode] = useState('');
    const [contractNumber, setContract] = useState('');
    const [countOfItem, setCount] = useState('');
    const [employeeId, setEmployee] = useState('');

    const memoDisabled = useMemo(() => {
        return (!type || !barcode || !contractNumber || !countOfItem || !employeeId);
    }, [type, barcode, contractNumber, countOfItem, employeeId,])

    const handleSubmit = (e) => {
        e.preventDefault();
        createData('/operation' ,{
            type: type,
            barcode: barcode,
            contractNumber: contractNumber,
            countOfItem: countOfItem,
            employeeId: employeeId,
        })
    }

    return (
        <form className="container_form" onSubmit={handleSubmit}>
            <Input label='Тип' change={(e) => setType(e.value)} />
            <Input label='Баркод' change={(e) => setbarcode(e.value)} />
            <Input label='Номер контракта' change={(e) => setContract(e.value)} />
            <Input label='Единицы' change={(e) => setCount(e.value)} />
            <Input label='ID Сотрудника' change={(e) => setEmployee(e.value)} />
            <button type="submit" className={memoDisabled ? 'disabled' : ''} disabled={memoDisabled} >Submit</button>
        </form>
    )
}