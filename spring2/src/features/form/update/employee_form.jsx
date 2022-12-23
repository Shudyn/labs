import { useMemo } from 'react';
import { useState } from 'react'
import { createData, updateData } from '../../../actions/actions';
import Input from '../../../components/input/input'
import '../form.css'

export default function CreateEmployeeForm() {
    const [id, setId] = useState('');
    const [name, setName] = useState('');
    const [passportId, setPassport] = useState('');
    const [phoneNumber, setPhone] = useState('');
    const [roleId, setRole] = useState('');

    const memoDisabled = useMemo(() => {
        return (!id);
    }, [id, name, passportId, phoneNumber, roleId])

    const handleSubmit = (e) => {
        e.preventDefault();
        updateData('/employee',{
            id: name,
            name: name,
            passportId: passportId,
            phoneNumber: phoneNumber,
            roleId : roleId
        }, id)
    }

    return (
        <form className="container_form" onSubmit={handleSubmit}>
            <Input label='Id' change={(e) => setId(e.value)} />
            <Input label='Имя' change={(e) => setName(e.value)} />
            <Input label='Паспорт' change={(e) => setPassport(e.value)} />
            <Input label='Телефон' change={(e) => setPhone(e.value)} />
            <Input label='Идентификатор роли' change={(e) => setRole(e.value)} />
            <button type="submit" className={memoDisabled ? 'disabled' : ''} disabled={memoDisabled} >Submit</button>
        </form>
    )
}