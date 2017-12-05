package br.com.servicemanager.filters;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(servletNames = "Faces Servlet", urlPatterns = "")
public class JPAFiltro implements Filter {

	private EntityManagerFactory entityManagerFactory;

	private String persistence_unit_name = "APPSM";

	public JPAFiltro() {

	}

	public void destroy() {

		this.entityManagerFactory.close();
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		EntityManager entityManager = this.entityManagerFactory.createEntityManager();

		request.setAttribute("entityManager", entityManager);

		entityManager.getTransaction().begin();

		chain.doFilter(request, response);

		try {

			entityManager.getTransaction().commit();

		} catch (Exception e) {

			entityManager.getTransaction().rollback();
		} finally {

			entityManager.close();
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {

		this.entityManagerFactory = Persistence.createEntityManagerFactory(this.persistence_unit_name);
	}
}
