import { useState } from 'react';
import { act } from 'react-dom/test-utils';
import './App.css';
import CreateEmployeeForm from './features/form/create/employee_form';
import CreateRoleForm from './features/form/create/role_form';
import CreateOperationForm from './features/form/create/operation_form';
import CreateMaterialValue from './features/form/create/materialValue_form';
import TableGenerator from './features/header_table';
import DeleteForm from './features/form/delete_form';
import UpdateEmployeeForm from './features/form/update/employee_form';
import UpdateMaterialValue from './features/form/update/materialValue_form';
import UpdateOperationForm from './features/form/update/operation_form';
import UpdateRoleForm from './features/form/update/role_form';

let actionSelect = [{ label: 'Получение' }, { label: 'Создание' }, { label: 'Обновление' }, { label: 'Удаление' }]
let dataSelect = [{ label: 'Сотрудники' }, { label: 'Должности' }, { label: 'Операции' }, { label: 'Материальные ценности' }]
function App() {

  const [action, setAction] = useState('Получение');
  const [data, setData] = useState(); 
  
  return (
    <div className="App">
      <div className="selector_container">
        {
          actionSelect.map(({ label }, index) => (
            <button className={`select_button ${action === label && 'active_select_button'}`} onClick={() => setAction(label)} key={index}>{label}</button>
          ))
        }
      </div>
      <div className="selector_container">
        {
          dataSelect.map(({ label }, index) => (
            <button className={`select_button ${data === label && 'active_select_button'}`} onClick={() => setData(label)} key={index}>{label}</button>
          ))
        }
      </div>
      <div className="content_container">
        { action === 'Создание' && data === 'Сотрудники' && <CreateEmployeeForm /> }
        { action === 'Создание' && data === 'Должности' && <CreateRoleForm /> }
        { action === 'Создание' && data === 'Операции' && <CreateOperationForm /> }
        { action === 'Создание' && data === 'Материальные ценности' && <CreateMaterialValue /> }

        { action === 'Получение' && data === 'Сотрудники' && <TableGenerator headArray={['id','Имя','Паспорт', 'Номер телефона','Должность']} bodyArray={['id','name','passportId', 'phoneNumber','roleTitle']} endpoint={'/employee'}/> }
        { action === 'Получение' && data === 'Должности' && <TableGenerator headArray={['id','Название', 'Зарплата']} bodyArray={['id','title','salary']} endpoint={'/role'}/> }
        { action === 'Получение' && data === 'Операции' && <TableGenerator headArray={['id','Тип', 'Баркод', 'Номер контракта', 'Количество','Общая стоимость', 'Выполнил']} bodyArray={['id','type','barcode', 'contractNumber' ,'countOfItem', 'price' ,'employeeName']} endpoint={'/operation'}/> }
        { action === 'Получение' && data === 'Материальные ценности' && <TableGenerator headArray={['Баркод','Тип упаковки', 'Стоимость']} bodyArray={['barcode','typeOfPackage','worth']} endpoint={'/material/value'}/> }

        { action === 'Обновление' && data === 'Сотрудники' && <UpdateEmployeeForm  endpoint={'/employee'}/> }
        { action === 'Обновление' && data === 'Должности' && <UpdateRoleForm  endpoint={'/role'}/> }
        { action === 'Обновление' && data === 'Операции' && <UpdateOperationForm endpoint={'/operation'}/> }
        { action === 'Обновление' && data === 'Материальные ценности' && <UpdateMaterialValue endpoint={'/material/value'}/> }

        { action === 'Удаление' && data === 'Сотрудники' && <DeleteForm  endpoint={'/employee'}/> }
        { action === 'Удаление' && data === 'Должности' && <DeleteForm  endpoint={'/role'}/> }
        { action === 'Удаление' && data === 'Операции' && <DeleteForm endpoint={'/operation'}/> }
        { action === 'Удаление' && data === 'Материальные ценности' && <DeleteForm endpoint={'/material/value'}/> }

      </div>
    </div>
  );
}

export default App;
