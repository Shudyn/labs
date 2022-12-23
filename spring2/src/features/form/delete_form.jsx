import { useMemo } from 'react';
import { useState } from 'react'
import { removeData } from '../../actions/actions';
import Input from '../../components/input/input'
import './form.css'

export default function DeleteForm({endpoint}) {
    const [id, setId] = useState('');

    const memoDisabled = useMemo(() => {
        return (!id);
    }, [id,])

    const handleSubmit = (e) => {
        e.preventDefault();
        removeData(endpoint, id)
    }

    return (
        <form className="container_form" onSubmit={handleSubmit}>
            <Input label='Идентификатор' change={(e) => setId(e.value)} />
            <button type="submit" className={memoDisabled ? 'disabled' : ''} disabled={memoDisabled} >Submit</button>
        </form>
    )
}