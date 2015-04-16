package japa.parser.ast.symtab;

import java.util.HashMap;

import se701.A2SemanticsException;

public abstract class ScopedSymbol extends Symbol implements Scope {

	private HashMap<String, Symbol> symbols = new HashMap<String, Symbol>();
	protected Scope enclosingScope = null;

	public ScopedSymbol(String name, SymtabType type, Scope enclosingScope) {
		super(name,type);
		this.enclosingScope = enclosingScope;
	}
	
	@Override
	public String getScopeName() {
		return name;
	}
	
	@Override
	public Scope getEnclosingScope() {
		return enclosingScope;
	}
	
	@Override
	public void define(Symbol symbol) {
		String name = symbol.getName();
		if (symbols.get(name) != null) {
			try {
				throw new A2SemanticsException("\""+name+"\" is already defined in scope "+getScopeName());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		symbols.put(name, symbol);
	}
	
	@Override
	public Symbol resolve(String name) {
		// if the symbol exists in the current scope, return it
		Symbol s = symbols.get(name);
		if (s != null)
			return s;
		
		// otherwise look in the enclosing scope, if there is one
		if (enclosingScope != null)
			return enclosingScope.resolve(name);
		
		// otherwise it doesn't exist
		return null;
	}

}
