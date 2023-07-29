package com.example.demo.funcional;
//especificar el tipo de dato puede ser un objeto o uno que ya existe en este
//caso un integer
public class PersonaSupplierImpl  implements IPersonaSupplier<String>{

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		String cedula = "1719954370";
		cedula = cedula + "zzzzzz";
		return cedula;
	}

}
