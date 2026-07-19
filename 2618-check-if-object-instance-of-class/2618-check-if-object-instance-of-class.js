/**
 * @param {any} object
 * @param {any} classFunction
 * @return {boolean}
 */
var checkIfInstanceOf = function(obj, classFunction) {
    if (obj == null || typeof classFunction != 'function' )
        return false;
    
    let val = (Object(obj) instanceof classFunction);
    return val;
};

/**
 * checkIfInstanceOf(new Date(), Date); // true
 */