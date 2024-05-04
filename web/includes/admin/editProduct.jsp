<%@taglib prefix="b" uri="/WEB-INF/tlds/buttonTags" %> 
            <div class="row">
                 <div class="col-lg-8 mx-auto">
                  <div class="card">
                    <div class="card-header py-3 bg-transparent"> 
                       <h5 class="mb-0">Edit Product</h5>
                      </div>
                    <div class="card-body">
                      <div class="border p-3 rounded">
                      <form id="editProductForm" class="row g-3" enctype="multipart/form-data">
                        <div class="col-12">
                          <label class="form-label">Product title</label>
                          <input type="text" class="form-control" placeholder="Product title" name="pro_name" id="pro_name">
                        </div>
                        <div class="col-12">
                          <label class="form-label">Full description</label>
                          <textarea class="form-control" placeholder="Full description" rows="4" cols="4" name="pro_desc" id="pro_desc"></textarea>
                        </div>
                        <div class="col-12 active" id="image_box">
                            <div class="d-flex align-items-center gap-5">
                                <div>
                                    <label class="form-label">Image</label>
                                    <img id="pro_img"/>
                                    <input type="hidden" id="img_input"/>
                                </div>
                                <div>
                                    <b:Button text="Change Image" outlined="false" rounded="false" id="change_image" onclick="changeImage()" /> 
                                </div>
                            </div>
                        </div>
                        <div class="col-12 hidden" id="image_input">
                            <label class="form-label">Images</label>
                            <input class="form-control" type="file" id="pro_img" >
                            <div class="w-50 mt-2">
                                <b:Button text="Cancel" outlined="false" rounded="false" id="cancel" onclick="cancelImageChange()" />
                            </div>
                        </div>
                        <div class="col-12 col-md-6">
                          <label class="form-label">Category</label>
                          <select class="form-select" id="pro_cat" name="pro_cat">
                            <option id="cat"></option>
                          </select>
                        </div>
                        <div class="col-12">
                          <label class="form-label">Price</label>
                          <div class="row g-3">
                            <div class="col-lg-9">
                                <input type="text" class="form-control" placeholder="Price" name="pro_price" id="pro_price">
                            </div>
                          </div>
                        </div>
                        <div class="col-12">
                          <div class="form-check">
                            <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                            <label class="form-check-label" for="flexCheckDefault">
                              Publish on website
                            </label>
                          </div>
                            <input type="hidden" name="pro_id" id="pro_id" />
                        </div>
                        <div class="col-12">
                           <b:Button text="Edit Product" rounded="false" outlined="false" onclick="updateProduct()" id="proBtn"/>
                        </div>
                      </form>
                      </div>
                     </div>
                    </div>
                 </div>
              </div>
