<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">

<head th:include="fragments/loginHeader :: loginHeader"></head>

<body>
  <div class="pace  pace-inactive">
    <div class="pace-progress" data-progress-text="100%" data-progress="99" style="transform: translate3d(100%, 0px, 0px);">
      <div class="pace-progress-inner"></div>
    </div>
    <div class="pace-activity"></div>
  </div>
  <div class="col-xl-12">
    <section class="box nobox">
      <div class="content-body">
        <div class="row">
          <div class="col-lg-12 col-md-12 col-12">

            <h3 class="page_error_code" style="color:#d2232a;">404</h3>
            <h4 class="page_error_info" style="color:#d2232a;">La pagina que intentas buscar no se encuentra en la plataforma</h4>

            <div class="col-12">
              <div class="row justify-content-center">
                <form action="javascript:;" method="post" class="page_error_search" style="width: 60%;">
                  <div class="text-center page_error_btn">
                    <a class="btn btn-primary btn-lg" href="/">
                      <i class="fa fa-location-arrow"></i> &nbsp; Regresar</a>
                  </div>
                </form>
              </div>
            </div>

          </div>
        </div>
      </div>
    </section>
  </div>

</body>

</html>