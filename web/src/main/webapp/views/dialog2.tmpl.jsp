<md-dialog aria-label="ALL COMMENTS">


    <link rel="stylesheet" href="css/rating.css">


    <form ng-cloak>
        <md-toolbar>
            <div class="md-toolbar-tools">
                <h2>HEI BUDDY</h2>
                <span flex></span>
                <md-button class="md-icon-button" ng-click="cancel()">
                    <md-icon md-svg-src="img/icons/ic_close_24px.svg" aria-label="Close dialog"></md-icon>
                </md-button>
            </div>
        </md-toolbar>

        <md-dialog-content style="background-color: #2299dd">
            <div class="md-dialog-content">
                <h2>Enter your opinion about our service</h2>
                <div flex>
                    <md-input-container flex>
                        <label style="color:white">comment</label>
                        <input required name="comment" ng-model="filters.comment" style="color: darkmagenta">
                        <div ng-messages="filters.comment.$error">
                            <div ng-message="required">This is required.</div>
                        </div>
                    </md-input-container>
                </div>
                <div flex>
                    <md-input-container flex>
                        <label style="color:white">Delivery Status</label>
                        <input required name="DeliveryStatus" ng-model="filters.delivery_status"
                               style="color: darkmagenta">
                        <div ng-messages="filters.DeliveryStatus.$error">
                            <div ng-message="required">This is required.</div>
                        </div>
                    </md-input-container>
                </div>

                <div flex>
                    <md-input-container flex>
                        <label style="color:white">Time Status</label>
                        <input required name="TimeStatus" ng-model="filters.time_status" style="color: darkmagenta">
                        <div ng-messages="filters.TimeStatus.$error">
                            <div ng-message="required">This is required.</div>
                        </div>
                    </md-input-container>
                </div>


                <md-radio-group ng-model="filters.starrate" required name="ofacility">

                    <md-radio-button value="10" class="md-primary" style="color:#ffffff;">*</md-radio-button>
                    <md-radio-button value="20" style="color:#ffffff;"> **</md-radio-button>
                    <md-radio-button value="30" class="md-primary" style="color:#ffffff;">***</md-radio-button>
                    <md-radio-button value="40" style="color:#ffffff;"> ****</md-radio-button>
                    <md-radio-button value="50" style="color:#ffffff;"> *****</md-radio-button>


                </md-radio-group>

                <!--<div class="acidjs-rating-stars">-->
                <!--<form>-->
                <!--<input ng-model="filters.ratingg" type="radio" name="group-1" id="group-1-0" value="50" /><label for="group-1-0"></label>&lt;!&ndash;-->
                <!--&ndash;&gt;<input ng-model="filters.ratingg" type="radio" name="group-1" id="group-1-1" value="40" /><label for="group-1-1"></label>&lt;!&ndash;-->
                <!--&ndash;&gt;<input ng-model="filters.ratingg" type="radio" name="group-1" id="group-1-2" value="30" /><label for="group-1-2"></label>&lt;!&ndash;-->
                <!--&ndash;&gt;<input ng-model="filters.ratingg" type="radio" name="group-1" id="group-1-3" value="20" /><label for="group-1-3"></label>&lt;!&ndash;-->
                <!--&ndash;&gt;<input ng-model="filters.ratingg" type="radio" name="group-1" id="group-1-4"  value="10" /><label for="group-1-4"></label>-->
                <!--</form>-->
                <!--</div>-->
            </div>
        </md-dialog-content>

        <md-dialog-actions layout="row" style="background-color: #2299dd">
            <!--<md-button href="http://en.wikipedia.org/wiki/Mango" target="_blank" md-autofocus>-->
            <!--More on Wikipedia-->
            <!--</md-button>-->
            <span flex></span>
            <md-button ng-click="answer('not useful')" style="background-color: #189800">
                Close
            </md-button>
            <md-button ng-click="addRating()" class="md-primary" style="background-color: #189800">
                Add Comment
            </md-button>
        </md-dialog-actions>
    </form>
</md-dialog>

