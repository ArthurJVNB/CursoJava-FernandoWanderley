package br.com.fwinternetbanking.dados;

import org.hibernate.Session;

import br.com.fwinternetbanking.exceptions.ContaExisteException;
import br.com.fwinternetbanking.exceptions.ContaNaoEncontradaException;
import br.com.fwinternetbanking.model.IRepConta;
import br.com.fwinternetbanking.model.contas.ContaAbstrata;
import br.com.fwinternetbanking.model.util.HibernateSessionFactory;

public class RepositorioContaHibernate implements IRepConta {

	@Override
	public void inserir(ContaAbstrata g) throws Exception {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		if ((ContaAbstrata) session.get(ContaAbstrata.class, g.getNumero()) == null) {
			session.save(g);
			session.close();
		} else {
			ContaExisteException e = new ContaExisteException();
			throw e;
		}
	}

	@Override
	public void atualizar(ContaAbstrata g) throws Exception {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		if ((ContaAbstrata) session.get(ContaAbstrata.class, g.getNumero()) != null) {
			session.saveOrUpdate(g);
			session.close();
		} else {
			ContaNaoEncontradaException e = new ContaNaoEncontradaException();
			throw e;
		}
	}

	@Override
	public void remover(ContaAbstrata g) throws Exception {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		if ((ContaAbstrata) session.get(ContaAbstrata.class, g.getNumero()) != null) {
			session.delete(g);
			session.close();
		} else {
			ContaNaoEncontradaException e = new ContaNaoEncontradaException();
			throw e;
		}
	}

	@Override
	public ContaAbstrata procurar(String chave) throws Exception {
		// TODO Auto-generated method stub
		ContaAbstrata contaAbs = null;
		Session session = HibernateSessionFactory.getSession();
		contaAbs = (ContaAbstrata) session.get(ContaAbstrata.class, chave);
		if (contaAbs == null) {
			ContaNaoEncontradaException e = new ContaNaoEncontradaException();
			throw e;
		}

		return contaAbs;
	}

}
