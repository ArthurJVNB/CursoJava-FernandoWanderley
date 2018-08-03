package br.com.fwinternetbanking.dados;

import org.hibernate.Session;

import br.com.fwinternetbanking.exceptions.ContaExisteException;
import br.com.fwinternetbanking.exceptions.ContaNaoEncontradaException;
import br.com.fwinternetbanking.model.ContaAbstrata;
import br.com.fwinternetbanking.model.IRepConta;
import br.com.fwinternetbanking.util.HibernateSessionFactory;

public class RepositorioContaHibernate implements IRepConta {

	@Override
	public void inserir(ContaAbstrata g) throws Exception {
		Session session = HibernateSessionFactory.getSession();
		if ((ContaAbstrata) session.get(ContaAbstrata.class, g.getNumero()) == null) {
			session.save(g);
			session.close();
		} else {
			throw new ContaExisteException();
		}
	}

	@Override
	public void atualizar(ContaAbstrata g) throws Exception {
		Session session = HibernateSessionFactory.getSession();
		if ((ContaAbstrata) session.get(ContaAbstrata.class, g.getNumero()) != null) {
			session.saveOrUpdate(g);
			session.close();
		} else {
			throw new ContaNaoEncontradaException();
		}
	}

	@Override
	public void remover(ContaAbstrata g) throws Exception {
		Session session = HibernateSessionFactory.getSession();
		if ((ContaAbstrata) session.get(ContaAbstrata.class, g.getNumero()) != null) {
			session.delete(g);
			session.close();
		} else {
			throw new ContaNaoEncontradaException();
		}
	}

	@Override
	public ContaAbstrata procurar(String chave) throws Exception {
		ContaAbstrata contaAbs = null;
		Session session = HibernateSessionFactory.getSession();
		contaAbs = (ContaAbstrata) session.get(ContaAbstrata.class, chave);
		if (contaAbs == null) {
			throw new ContaNaoEncontradaException();
		}

		return contaAbs;
	}

}
