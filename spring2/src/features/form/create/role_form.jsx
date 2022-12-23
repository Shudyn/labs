import { useMemo } from 'react';
import { useState } from 'react'
import { createData } from '../../../actions/actions';
import Input from '../../../components/input/input'
import '../form.css'

export default function CreateRoleForm() {
    const [title, setTitle] = useState('');
    const [salary, setSalary] = useState('');

    const memoDisabled = useMemo(() => {
        return (!title || !salary);
    }, [title, salary])

    const handleSubmit = (e) => {
        e.preventDefault();
        createData('/role' ,{
            title: title,
            salary: salary
        })
    }

    return (
        <form className="container_form" onSubmit={handleSubmit}>
            <Input label='Название' change={(e) => setTitle(e.value)} />
            <Input label='Зарплата' change={(e) => setSalary(e.value)} />
            <button type="submit" className={memoDisabled ? 'disabled' : ''} disabled={memoDisabled} >Submit</button>
        </form>
    )
}