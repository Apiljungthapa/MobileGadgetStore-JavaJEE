<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta
      name="viewport"
      content="width=device-width,initial-scale=1,maximum-scale=1"
    />
    <title>ByteBazzar Admin Panel</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/admin.css" />
    <link
      rel="stylesheet"
      href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css"
    />
  </head>
  <body>
    <input type="checkbox" id="menu-toggle" />
    
    <jsp:include page="admin_sidebar.jsp" />
   
    <div class="main-content">
    
    <jsp:include page="admin_header.jsp" />
     
      <main>
        <div class="page-header">
          <h1>ByteBazzar Admin Panel</h1>
        </div>

        <div class="page-content">
          <div class="records table-responsive">
            <div class="record-header">
              <div>
                <h3>Customer Messages</h3>
              </div>

              <div class="browse">
                <form>
                  <div class="search-container">
                    <input
                      type="text"
                      name="q"
                      class="search-input"
                      placeholder="Search..."
                      required
                    />
                    <button type="submit" class="search-button">
                      <i class="las la-search" style="font-size: 22px"></i>
                    </button>
                  </div>
                </form>
              </div>
            </div>

            <div>
              <table width="100%">
                <thead>
                  <tr>
                    <th>Id</th>
                    <th><span class="las la-sort"></span> Customer Name</th>
                    <th><span class="las la-sort"></span> Message Title</th>
                    <th><span class="las la-sort"></span> Created Date</th>
                    <th><span class="las la-sort"></span> ACTIONS</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>#5033</td>
                    <td>
                      <div class="client">
                        <div
                          class="client-img bg-img"
                          style="background-image: url(../images/apil.jpg)"
                        ></div>
                        <div class="client-info">
                          <h4>Apil Thapa</h4>
                          <small>Apil@gmail.com</small>
                        </div>
                      </div>
                    </td>
                    <td>
                      asking about phone details and delivery inquiry outside
                      valley
                    </td>

                    <td>2019-09-12</td>

                    <td>
                      <div class="actions">
                        <a href="customer-mail.jsp" class="dev-act">
                          <span class="las la-eye"></span>
                        </a>
                        <a href="#" class="dev-act">
                          <span class="las la-trash-alt"></span>
                        </a>
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td>#5033</td>
                    <td>
                      <div class="client">
                        <div
                          class="client-img bg-img"
                          style="background-image: url(../images/apil.jpg)"
                        ></div>
                        <div class="client-info">
                          <h4>Apil Thapa</h4>
                          <small>Apil@gmail.com</small>
                        </div>
                      </div>
                    </td>
                    <td>
                      asking about phone details and delivery inquiry outside
                      valley
                    </td>

                    <td>2019-09-12</td>

                    <td>
                      <div class="actions">
                        <a href="customer-mail.jsp" class="dev-act">
                          <span class="las la-eye"></span>
                        </a>
                        <a href="#" class="dev-act">
                          <span class="las la-trash-alt"></span>
                        </a>
                      </div>
                    </td>
                  </tr>

                  <tr>
                    <td>#5033</td>
                    <td>
                      <div class="client">
                        <div
                          class="client-img bg-img"
                          style="background-image: url(../images/apil.jpg)"
                        ></div>
                        <div class="client-info">
                          <h4>Apil Thapa</h4>
                          <small>Apil@gmail.com</small>
                        </div>
                      </div>
                    </td>
                    <td>
                      asking about phone details and delivery inquiry outside
                      valley
                    </td>

                    <td>2019-09-12</td>

                    <td>
                      <div class="actions">
                        <a href="customer-mail.jsp" class="dev-act">
                          <span class="las la-eye"></span>
                        </a>
                        <a href="#" class="dev-act">
                          <span class="las la-trash-alt"></span>
                        </a>
                      </div>
                    </td>
                  </tr>

                  <tr>
                    <td>#5033</td>
                    <td>
                      <div class="client">
                        <div
                          class="client-img bg-img"
                          style="background-image: url(../images/apil.jpg)"
                        ></div>
                        <div class="client-info">
                          <h4>Apil Thapa</h4>
                          <small>Apil@gmail.com</small>
                        </div>
                      </div>
                    </td>
                    <td>
                      asking about phone details and delivery inquiry outside
                      valley
                    </td>

                    <td>2019-09-12</td>

                    <td>
                      <div class="actions">
                        <a href="customer-mail.jsp" class="dev-act">
                          <span class="las la-eye"></span>
                        </a>
                        <a href="#" class="dev-act">
                          <span class="las la-trash-alt"></span>
                        </a>
                      </div>
                    </td>
                  </tr>

                  <tr>
                    <td>#5033</td>
                    <td>
                      <div class="client">
                        <div
                          class="client-img bg-img"
                          style="background-image: url(../images/apil.jpg)"
                        ></div>
                        <div class="client-info">
                          <h4>Apil Thapa</h4>
                          <small>Apil@gmail.com</small>
                        </div>
                      </div>
                    </td>
                    <td>
                      asking about phone details and delivery inquiry outside
                      valley
                    </td>

                    <td>2019-09-12</td>

                    <td>
                      <div class="actions">
                        <a href="customer-mail.jsp" class="dev-act">
                          <span class="las la-eye"></span>
                        </a>
                        <a href="#" class="dev-act">
                          <span class="las la-trash-alt"></span>
                        </a>
                      </div>
                    </td>
                  </tr>

                  <tr>
                    <td>#5033</td>
                    <td>
                      <div class="client">
                        <div
                          class="client-img bg-img"
                          style="background-image: url(../images/apil.jpg)"
                        ></div>
                        <div class="client-info">
                          <h4>Apil Thapa</h4>
                          <small>Apil@gmail.com</small>
                        </div>
                      </div>
                    </td>
                    <td>
                      asking about phone details and delivery inquiry outside
                      valley
                    </td>

                    <td>2019-09-12</td>

                    <td>
                      <div class="actions">
                        <a href="customer-mail.jsp" class="dev-act">
                          <span class="las la-eye"></span>
                        </a>
                        <a href="#" class="dev-act">
                          <span class="las la-trash-alt"></span>
                        </a>
                      </div>
                    </td>
                  </tr>

                  <tr>
                    <td>#5033</td>
                    <td>
                      <div class="client">
                        <div
                          class="client-img bg-img"
                          style="background-image: url(../images/apil.jpg)"
                        ></div>
                        <div class="client-info">
                          <h4>Apil Thapa</h4>
                          <small>Apil@gmail.com</small>
                        </div>
                      </div>
                    </td>
                    <td>
                      asking about phone details and delivery inquiry outside
                      valley
                    </td>

                    <td>2019-09-12</td>

                    <td>
                      <div class="actions">
                        <a href="customer-mail.jsp" class="dev-act">
                          <span class="las la-eye"></span>
                        </a>
                        <a href="#" class="dev-act">
                          <span class="las la-trash-alt"></span>
                        </a>
                      </div>
                    </td>
                  </tr>

                  <tr>
                    <td>#5033</td>
                    <td>
                      <div class="client">
                        <div
                          class="client-img bg-img"
                          style="background-image: url(../images/apil.jpg)"
                        ></div>
                        <div class="client-info">
                          <h4>Apil Thapa</h4>
                          <small>Apil@gmail.com</small>
                        </div>
                      </div>
                    </td>
                    <td>
                      asking about phone details and delivery inquiry outside
                      valley
                    </td>

                    <td>2019-09-12</td>

                    <td>
                      <div class="actions">
                        <a href="customer-mail.jsp" class="dev-act">
                          <span class="las la-eye"></span>
                        </a>
                        <a href="#" class="dev-act">
                          <span class="las la-trash-alt"></span>
                        </a>
                      </div>
                    </td>
                  </tr>

                  <tr>
                    <td>#5033</td>
                    <td>
                      <div class="client">
                        <div
                          class="client-img bg-img"
                          style="background-image: url(../images/apil.jpg)"
                        ></div>
                        <div class="client-info">
                          <h4>Apil Thapa</h4>
                          <small>Apil@gmail.com</small>
                        </div>
                      </div>
                    </td>
                    <td>
                      asking about phone details and delivery inquiry outside
                      valley
                    </td>

                    <td>2019-09-12</td>

                    <td>
                      <div class="actions">
                        <a href="customer-mail.jsp" class="dev-act">
                          <span class="las la-eye"></span>
                        </a>
                        <a href="#" class="dev-act">
                          <span class="las la-trash-alt"></span>
                        </a>
                      </div>
                    </td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </main>
    </div>
  </body>
</html>
    