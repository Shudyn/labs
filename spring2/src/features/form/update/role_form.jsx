import { useMemo } from 'react';
import { useState } from 'react'
import { createData, updateData } from '../../../actions/actions';
import Input from '../../../components/input/input'
import '../form.css'

export default function CreateRoleForm() {
    const [id, setId] = useState('');
    const [title, setTitle] = useState('');
    const [salary, setSalary] = useState('');

    const memoDisabled = useMemo(() => {
        return (!id);
    }, [id, title, salary])

    const handleSubmit = (e) => {
        e.preventDefault();
        updateData('/role' ,{
            id: id,
            title: title,
            salary: salary
        }, id)
    }

    return (
        <form className="container_form" onSubmit={handleSubmit}>
            <Input label='ID' change={(e) => setId(e.value)} />
            <Input label='Название' change={(e) => setTitle(e.value)} />
            <Input label='Зарплата' change={(e) => setSalary(e.value)} />
            <button type="submit" className={memoDisabled ? 'disabled' : ''} disabled={memoDisabled} >Submit</button>
        </form>
    )
}