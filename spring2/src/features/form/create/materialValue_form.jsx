import { useMemo } from 'react';
import { useState } from 'react'
import { createData } from '../../../actions/actions';
import Input from '../../../components/input/input'
import '../form.css'

export default function CreateMaterialValue() {
    const [barcode, setBarcode] = useState('');
    const [typeOfPackage, setTypeOfPackage] = useState('');
    const [worth, setWorth] = useState('');

    const memoDisabled = useMemo(() => {
        return (!barcode || !typeOfPackage || !worth);
    }, [barcode, typeOfPackage, worth])

    const handleSubmit = (e) => {
        e.preventDefault();
        createData('/material/value' ,{
            barcode: barcode,
            typeOfPackage: typeOfPackage,
            worth: worth
        })
    }

    return (
        <form className="container_form" onSubmit={handleSubmit}>
            <Input label='Баркод' change={(e) => setBarcode(e.value)} />
            <Input label='Тип пакета' change={(e) => setTypeOfPackage(e.value)} />
            <Input label='Стоимость' change={(e) => setWorth(e.value)} />
            <button type="submit" className={memoDisabled ? 'disabled' : ''} disabled={memoDisabled} >Submit</button>
        </form>
    )
}